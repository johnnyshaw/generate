package ${model.packageName};

import org.springframework.stereotype.Repository;
import com.trendcom.dao.*;
import com.trendcom.model.*;


@Repository
public class ${model.className} extends BaseHibernateDaoImpl<${model.changeClass}> implements ${model.implementsName} {
 
}
