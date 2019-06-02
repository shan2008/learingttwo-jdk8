package com.yous.learningtwo.host.rmi;

import com.yous.learningtwo.host.dto.Student;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author syou
 * @date 2019/5/12.
 */
public interface UserHander extends Remote {
    Student getStudent() throws RemoteException;

    int getId()  throws RemoteException;
}
