package com.example

import org.slf4j.LoggerFactory
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.validation.annotation.Validated
import org.springframework.web.reactive.config.EnableWebFlux
import javax.annotation.PostConstruct

fun main(args: Array<String>) {
    SpringApplication(Application::class.java).run(*args)
}

@SpringBootApplication
@EnableWebFlux
class Application(val properties: Properties) {

    private final val log = LoggerFactory.getLogger(Application::class.java)

    @PostConstruct
    fun init() {
        log.debug("Value of custom.test: ${properties.test}")
    }
}

@Configuration
@ConfigurationProperties(prefix = "custom")
@Validated
class Properties {
    var test = TestEnum.VALUE1
}

enum class TestEnum {VALUE1, VALUE2}
