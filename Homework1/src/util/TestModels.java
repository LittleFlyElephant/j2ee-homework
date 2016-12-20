package util;

import models.CourseSelectModel;
import models.UserModel;

/**
 * Created by raychen on 2016/12/20.
 */
public class TestModels {
    public static void main(String[] args) {
        Result rs = UserModel.queryUser("cr");
        System.out.println(rs.message);
        UserModel user = (UserModel) rs.value;
        Result rs2 = CourseSelectModel.queryScore(1, 1);
        System.out.println(rs2.message);
        System.out.println(rs2.value);
    }
}
