package com.octoacme.xmlprocessor.service;

import com.octoacme.xmlprocessor.entity.MessageLog;
import com.octoacme.xmlprocessor.handler.OutputHandler;
import com.octoacme.xmlprocessor.handler.ResponseHandler;
import com.octoacme.xmlprocessor.model.MessageEnvelope;
import com.octoacme.xmlprocessor.model.ResponseStatus;
import com.octoacme.xmlprocessor.repository.MessageLogRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MessageProcessingServiceTest {

    @Mock
    private XmlValidationService xmlValidationService;

    @Mock
    private ResponseHandler responseHandler;

    @Mock
    private OutputHandler outputHandler;

    @Mock
    private MessageLogRepository messageLogRepository;

    private MessageProcessingService service;

    @BeforeEach
    void setUp() {
        service = new MessageProcessingService(
                xmlValidationService, responseHandler, outputHandler, messageLogRepository);
    }

    @Test
    void validMessage_sendsAckAndForwardsToOutput() {
        MessageEnvelope envelope = new MessageEnvelope("msg-1", "corr-1", "<root/>");
        when(xmlValidationService.isValid("<root/>")).thenReturn(true);
        when(messageLogRepository.save(any())).thenAnswer(inv -> inv.getArgument(0));

        service.process(envelope);

        verify(responseHandler).sendAck("msg-1", "corr-1");
        verify(outputHandler).forward("<root/>");
        verify(responseHandler, never()).sendNack(any(), any(), any());

        ArgumentCaptor<MessageLog> logCaptor = ArgumentCaptor.forClass(MessageLog.class);
        verify(messageLogRepository).save(logCaptor.capture());
        assertThat(logCaptor.getValue().getStatus()).isEqualTo(ResponseStatus.ACK);
        assertThat(logCaptor.getValue().getValidationError()).isNull();
    }

    @Test
    void invalidMessage_sendsNackAndDoesNotForwardToOutput() {
        MessageEnvelope envelope = new MessageEnvelope("msg-2", "corr-2", "<bad>");
        when(xmlValidationService.isValid("<bad>")).thenReturn(false);
        when(xmlValidationService.getValidationError("<bad>")).thenReturn("XML is malformed");
        when(messageLogRepository.save(any())).thenAnswer(inv -> inv.getArgument(0));

        service.process(envelope);

        verify(responseHandler).sendNack("msg-2", "corr-2", "XML is malformed");
        verify(outputHandler, never()).forward(any());
        verify(responseHandler, never()).sendAck(any(), any());

        ArgumentCaptor<MessageLog> logCaptor = ArgumentCaptor.forClass(MessageLog.class);
        verify(messageLogRepository).save(logCaptor.capture());
        assertThat(logCaptor.getValue().getStatus()).isEqualTo(ResponseStatus.NACK);
        assertThat(logCaptor.getValue().getValidationError()).isEqualTo("XML is malformed");
    }
}
