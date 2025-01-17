package com.mifel.app.banca.propertie;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.converter.RsaKeyConverters;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.security.interfaces.RSAPrivateKey;

@Component
@ConfigurationPropertiesBinding
public class PrivateKeyConverter implements Converter<String, RSAPrivateKey> {
    @Override
    public RSAPrivateKey convert(String from) {
        return RsaKeyConverters.pkcs8().convert(new ByteArrayInputStream(from.getBytes()));
    }
}