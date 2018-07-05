package com.bcp.teletransfer.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.bcp.teletransfer.entity.Usuario;
import com.primeur.bcp.teletransfer.common.model.Company;


@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
	
	
    @Bean
    public ItemReader<Usuario> reader() {
        FlatFileItemReader<Usuario> reader = new FlatFileItemReader<Usuario>();
        reader.setResource(new ClassPathResource("tt_usuario_test.csv"));
        reader.setLineMapper(new DefaultLineMapper<Usuario>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[] {"chrCodigoUsuario","vchNombreUsuario","chrTipoDocIdentidad","chrDocumento","vchResponsable","vchTelefono","vchFax","vchDireccion","vchEMail","vchDepartamento","vchProvincia","vchDistrito","vchFrecuenciaUso","intVolumenPromedio"});
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<Usuario>() {{
                setTargetType(Usuario.class);
            }});
        }});
        return reader;
    }
    
    @Bean
    public ItemProcessor<Usuario, Company> processor() {
        return new EmpresaItemProcessor();
    }
    
    
    @Bean
    public Step step(StepBuilderFactory stepBuilderFactory, ItemReader<Usuario> reader, ItemProcessor<Usuario, Company> processor) {
        return stepBuilderFactory.get("step")
                .<Usuario, Company> chunk(3)
                .reader(reader)
                .processor(processor)
//                .writer(writer)
                .build();
    }
    
    @Bean
    public Job createCompany(JobBuilderFactory jobs, Step step) {
        return jobs.get("createCompany")
                .flow(step)
                .end()
                .build();
    }

}
