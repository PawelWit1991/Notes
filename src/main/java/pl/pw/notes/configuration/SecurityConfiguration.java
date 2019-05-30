package pl.pw.notes.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import pl.pw.notes.converter.NoteConverter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll();
    }


    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(getNoteConverter());
    }

    @Bean
    public NoteConverter getNoteConverter() {
        return new NoteConverter();
    }
}