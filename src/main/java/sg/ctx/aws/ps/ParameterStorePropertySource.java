package sg.ctx.aws.ps;

import org.springframework.core.env.PropertySource;

public class ParameterStorePropertySource extends PropertySource<ParameterStoreSource>
{
    public static final String PARAMETER_STORE_HIERARCHY_SPLIT_CHARACTER = "aws.ps.";

    public ParameterStorePropertySource(String name, ParameterStoreSource source)
    {
        super(name, source);
    }
    @Override
    public Object getProperty(String name)
    {
        if (name.startsWith(PARAMETER_STORE_HIERARCHY_SPLIT_CHARACTER)) {
            var key = name.replace("aws.ps.","");
            return source.getProperty(key);
        }
        return null;
    }
}
