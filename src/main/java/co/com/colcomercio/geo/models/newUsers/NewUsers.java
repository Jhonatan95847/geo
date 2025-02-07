package co.com.colcomercio.geo.models.newUsers;

import co.com.colcomercio.geo.models.users.DataUsers;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class NewUsers {
    private String key;
    private DataNewUsers dataNewUsers;
}
