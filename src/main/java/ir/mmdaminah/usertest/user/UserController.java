package ir.mmdaminah.usertest.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@RestController
public class UserController {

    @Autowired
    private IUserDAO api;

    @GetMapping(value = "/users")
    public List<UserDto> findAll(@RequestParam(value = "search", required = false) String search) {
        List<SearchCriteria> params = new ArrayList<SearchCriteria>();
        if (search != null) {
            Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
            Matcher matcher = pattern.matcher(search + ", ");
            while (matcher.find()) {
                params.add(new SearchCriteria(
                        matcher.group(1),
                        matcher.group(2),
                        matcher.group(3)
                ));
            }
        }
        return api.searchUser(params).stream().map(user ->
                new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getAge())
        ).collect(Collectors.toList());
    }

}
