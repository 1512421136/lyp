package com.hp.onlinexam.service.login;

import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.po.Teacher;

/**
 * 通过登录信息判断是否能够成功登录
 * @author yangzhen
 *
 */
public interface ILoginService {

	public Teacher canLogin(Teacher t);
	public Student canLogin(Student s);
}
