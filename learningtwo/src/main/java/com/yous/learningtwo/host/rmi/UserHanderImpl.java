package com.yous.learningtwo.host.rmi;

import com.yous.learningtwo.host.dto.Student;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author syou
 * @date 2019/5/12.
 */
public class UserHanderImpl extends UnicastRemoteObject implements UserHander {

    public UserHanderImpl() throws RemoteException {
        super();
    }

    @Override
    public Student getStudent() throws RemoteException {
        return new Student(1,"shan");
    }

    @Override
    public int getId() throws RemoteException {
        return 999;
    }
}
