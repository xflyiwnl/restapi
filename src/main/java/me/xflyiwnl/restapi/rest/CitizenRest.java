package me.xflyiwnl.restapi.rest;

import me.xflyiwnl.restapi.RestAPI;
import me.xflyiwnl.restapi.entity.Citizen;
import me.xflyiwnl.restapi.service.CitizenService;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class CitizenRest {

    @GetMapping("/v1/citizens")
    public String all() {

        CitizenService service = RestAPI.getInstance().getServices().getCitizen();

        JSONObject result = new JSONObject();
        result.put("time", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));

        List<Citizen> citizens = service.all();
        for (Citizen citizen : citizens) {
            service.delete(citizen);
        }

        result.put("status", !citizens.isEmpty() ? RestResult.OK : RestResult.ERROR);

        if (!citizens.isEmpty()) {
            JSONObject citizensJSON = new JSONObject();
            for (Citizen citizen : citizens) {
                citizensJSON.put(citizen.getUniqueId().toString(), citizen.toJSON());
            }
            result.put("content", citizensJSON);
        } else {
            result.put("content", "null");
        }

        return result.toString();
    }

    @GetMapping("/v1/citizen/{uniqueId}")
    public String get(@PathVariable String uniqueId) {

        CitizenService service = RestAPI.getInstance().getServices().getCitizen();

        JSONObject result = new JSONObject();
        result.put("time", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));

        Citizen citizen = service.get(uniqueId);

        result.put("status", citizen != null ? RestResult.OK : RestResult.ERROR);
        result.put("content", citizen != null ? citizen.toJSON() : "null");

        return result.toString();
    }

}
