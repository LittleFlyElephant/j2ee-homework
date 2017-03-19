package factory;

import service.HomeService;
import service.LoginService;
import service.impl.HomeServiceImpl;
import service.impl.LoginSerivceImpl;

/**
 * Created by raychen on 2017/1/1.
 */
public class ServiceFactory {
    private static ServiceFactory factory = new ServiceFactory();
    private ServiceFactory(){}
    public static ServiceFactory getInstance() {
        return factory;
    }

    public HomeService getHomeService(){
        return new HomeServiceImpl();
    }
    public LoginService getLoginService() {
        return new LoginSerivceImpl();
    }
}
