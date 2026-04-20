package com.octoacme.xmlprocessor.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Validates whether a given string is well-formed XML.
 *
 * <p>Uses a namespace-aware, non-validating {@link javax.xml.parsers.DocumentBuilder}
 * to parse the payload.  External entity processing is disabled to prevent XXE attacks.
 */
@Service
public class XmlValidationService {

    private static final Logger log = LoggerFactory.getLogger(XmlValidationService.class);

    /**
     * Validates that {@code xmlPayload} is well-formed XML.
     *
     * @param xmlPayload the raw XML string to validate
     * @return {@code true} when the payload is valid XML, {@code false} otherwise
     */
    public boolean isValid(String xmlPayload) {
        if (xmlPayload == null || xmlPayload.isBlank()) {
            log.debug("XML payload is null or blank – rejecting");
            return false;
        }
        try {
            parse(xmlPayload);
            return true;
        } catch (SAXException e) {
            log.debug("XML payload is not well-formed: {}", e.getMessage());
            return false;
        } catch (ParserConfigurationException | IOException e) {
            log.error("Unexpected error during XML validation", e);
            return false;
        }
    }

    /**
     * Returns a human-readable reason why validation failed.
     *
     * @param xmlPayload the raw XML string to validate
     * @return a description of the parse error, or {@code null} when valid
     */
    public String getValidationError(String xmlPayload) {
        if (xmlPayload == null || xmlPayload.isBlank()) {
            return "XML payload is null or blank";
        }
        try {
            parse(xmlPayload);
            return null;
        } catch (SAXException e) {
            return e.getMessage();
        } catch (ParserConfigurationException | IOException e) {
            return "Internal parser error: " + e.getMessage();
        }
    }

    /**
     * Parses {@code xmlPayload} using an XXE-safe {@link DocumentBuilderFactory}.
     *
     * @throws SAXException              when the payload is not well-formed XML
     * @throws ParserConfigurationException when the parser cannot be configured
     * @throws IOException               on I/O errors
     */
    private void parse(String xmlPayload) throws SAXException, ParserConfigurationException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        // Disable external entity processing to prevent XXE attacks
        factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
        factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        factory.newDocumentBuilder()
               .parse(new ByteArrayInputStream(xmlPayload.getBytes(StandardCharsets.UTF_8)));
    }
}
