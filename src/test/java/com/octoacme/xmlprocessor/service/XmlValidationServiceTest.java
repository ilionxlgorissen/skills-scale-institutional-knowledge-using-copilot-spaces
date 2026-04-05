package com.octoacme.xmlprocessor.service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class XmlValidationServiceTest {

    private final XmlValidationService service = new XmlValidationService();

    @Test
    void validXml_returnsTrue() {
        String xml = "<root><child>value</child></root>";
        assertThat(service.isValid(xml)).isTrue();
    }

    @Test
    void validXmlWithNamespace_returnsTrue() {
        String xml = "<ns:root xmlns:ns=\"http://example.com\"><ns:child>value</ns:child></ns:root>";
        assertThat(service.isValid(xml)).isTrue();
    }

    @Test
    void malformedXml_returnsFalse() {
        String xml = "<root><unclosed>";
        assertThat(service.isValid(xml)).isFalse();
    }

    @Test
    void nullPayload_returnsFalse() {
        assertThat(service.isValid(null)).isFalse();
    }

    @Test
    void blankPayload_returnsFalse() {
        assertThat(service.isValid("   ")).isFalse();
    }

    @Test
    void notXml_returnsFalse() {
        assertThat(service.isValid("this is plain text")).isFalse();
    }

    @Test
    void xmlWithDoctype_returnsFalse() {
        // DOCTYPE declarations are disabled to prevent XXE attacks
        String xml = "<!DOCTYPE foo [<!ENTITY xxe SYSTEM \"file:///etc/passwd\">]><foo>&xxe;</foo>";
        assertThat(service.isValid(xml)).isFalse();
    }

    @Test
    void validXml_getValidationError_returnsNull() {
        String xml = "<root/>";
        assertThat(service.getValidationError(xml)).isNull();
    }

    @Test
    void malformedXml_getValidationError_returnsMessage() {
        String xml = "<root><unclosed>";
        assertThat(service.getValidationError(xml)).isNotBlank();
    }

    @Test
    void nullPayload_getValidationError_returnsMessage() {
        assertThat(service.getValidationError(null)).isNotBlank();
    }
}
