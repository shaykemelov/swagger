package kz.shaykemelov.examples.swagger.controllers;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
        value = "/api/demo/value",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class DemoController
{
    private volatile String value = null;

    public record ValueDto(
            @JsonProperty("value")
            String value)
    {}

    @GetMapping
    public ValueDto get()
    {
        return new ValueDto(value);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void put(
            @RequestBody
            final ValueDto valueDto
    )
    {
        this.value = valueDto.value();
    }
}
