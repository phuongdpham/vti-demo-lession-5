package com.example.demolession5.config;

import com.example.demolession5.repository.DepartmentRepository;
import com.example.demolession5.repository.InmemDepartmentRepositoryImpl;
import com.example.demolession5.service.DepartmentService;
import com.example.demolession5.service.DepartmentServiceImpl;
import com.example.demolession5.service.SayHiService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {

    @Bean
    DepartmentRepository departmentRepository() {
        return new InmemDepartmentRepositoryImpl();
    }

    @Bean(name = "departmentService")
    @Primary
    DepartmentService departmentService(DepartmentRepository repository) {
        return new DepartmentServiceImpl(repository);
    }

    @Bean(name = "departmentService2")
    DepartmentService departmentService2(DepartmentRepository repository) {
        return new DepartmentServiceImpl(repository);
    }

    @Bean
    SayHiService sayHiService() {
        return () -> "Hi";
    }
}
