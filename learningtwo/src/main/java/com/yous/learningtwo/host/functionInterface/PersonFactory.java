package com.yous.learningtwo.host.functionInterface;

import com.yous.learningtwo.host.Person;
import com.yous.learningtwo.host.dto.Student;

/**
 * @author syou
 * @date 2019/5/7.
 */
public interface PersonFactory<P extends Student> {
    P create(int id, String name);
}
