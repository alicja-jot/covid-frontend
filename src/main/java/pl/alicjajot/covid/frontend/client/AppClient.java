package pl.alicjajot.covid.frontend.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.alicjajot.covid.frontend.dto.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Service
public class AppClient{

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    public List<CaseDto> getCases() {
        ResponseEntity<CaseDto[]> resposeEntity = restTemplateBuilder.build().getForEntity("http://localhost:8090/v1/case", CaseDto[].class);
        CaseDto[] body = resposeEntity.getBody();


        return Arrays.asList(body) ;
    }

    public List<HospitalDto> getHospitals() {
        ResponseEntity<HospitalDto[]> resposeEntity = restTemplateBuilder.build().getForEntity("http://localhost:8090/v1/hospital", HospitalDto[].class);
        HospitalDto[] body = resposeEntity.getBody();


        return Arrays.asList(body) ;
    }

    public void postCase(CaseDto caseDto) {
        restTemplateBuilder.build().postForEntity("http://localhost:8090/v1/case", caseDto, CaseDto.class);

        return;
    }

    public void postHospital(HospitalDto hospitalDto) {
        restTemplateBuilder.build().postForEntity("http://localhost:8090/v1/hospital", hospitalDto, HospitalDto.class);
    }

    public List<CountryDto> getCountries() {
        ResponseEntity<CountryDto[]> resposeEntity = restTemplateBuilder.build().getForEntity("http://localhost:8090/v1/country", CountryDto[].class);
        CountryDto[] body = resposeEntity.getBody();


        return Arrays.asList(body) ;
    }

    public void update() {
        restTemplateBuilder.build().postForEntity("http://localhost:8090/v1/covid/update", null, Object.class);
    }

    public List<RestActionLogDto> getRestCalls() {
        ResponseEntity<RestActionLogDto[]> resposeEntity = restTemplateBuilder.build().getForEntity("http://localhost:8090/v1/log/rest", RestActionLogDto[].class);
        RestActionLogDto[] body = resposeEntity.getBody();


        return Arrays.asList(body) ;
    }

    public List<CovidApiActionLogDto> getApiCalls() {
        ResponseEntity<CovidApiActionLogDto[]> resposeEntity = restTemplateBuilder.build().getForEntity("http://localhost:8090/v1/log/api", CovidApiActionLogDto[].class);
        CovidApiActionLogDto[] body = resposeEntity.getBody();


        return Arrays.asList(body) ;
    }
}
