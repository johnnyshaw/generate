package ${model.packageName};

import org.springframework.stereotype.Repository;
import com.johnny.service.*;
import com.trendcom.model.*;


@Repository
public class ${model.className} extends BaseHibernateDaoImpl<${model.changeClass}> implements ${model.implementsName} {
 
}
