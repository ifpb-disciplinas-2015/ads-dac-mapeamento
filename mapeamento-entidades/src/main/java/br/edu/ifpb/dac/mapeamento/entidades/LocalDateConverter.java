package br.edu.ifpb.dac.mapeamento.entidades;

import java.time.LocalDate;
import java.sql.Date;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author Ricardo Job
 */
@Converter(autoApply = true)
public class LocalDateConverter 
implements AttributeConverter<LocalDate, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDate date) {
        return Date.valueOf(date);
    }

    @Override
    public LocalDate convertToEntityAttribute(Date value) {
        return value.toLocalDate();
    }
}
