package info.yangguo.waf.dto;

import info.yangguo.waf.validator.CheckItermConfig;
import info.yangguo.waf.validator.Exist;
import info.yangguo.waf.validator.NotExist;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@CheckItermConfig(groups = Exist.class)
public class RequestItermConfigDto {
    @NotEmpty
    @Pattern(regexp = "info\\.yangguo\\.waf\\.request\\..*HttpRequestFilter")
    @ApiModelProperty(value = "request拦截器名称", required = true)
    private String filterName;
    @NotEmpty
    @ApiModelProperty(value = "配置项名称", required = true)
    private String name;
    @NotNull(groups = Exist.class)
    @Null(groups = NotExist.class)
    @ApiModelProperty(value = "是否开启，true启用，false关闭。")
    private Boolean isStart;
    @Null(groups = NotExist.class)
    @ApiModelProperty(value = "iterm扩展信息，目前只在CCHttpFilter有使用。")
    private Map<String, Object> extension;
}
