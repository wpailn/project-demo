package com.wp;

import static org.junit.Assert.assertTrue;

import com.google.gson.Gson;
import com.wp.pojo.bo.UserBO;
import com.wp.pojo.vo.UserVO;
import com.wp.util.GsonUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.SystemUtils;
import org.junit.Test;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Unit test for simple App.
 */

public class ApplicationTest
{
    @Test
    public void shouldAnswerWithTrue() throws Exception {
        List<String> macs = getMacList();
        System.out.println("本机的mac网卡的地址有：" + macs);
        System.out.println("默认取第一个mac网卡地址");

    }

    /***因为一台机器不一定只有一个网卡呀，所以返回的是数组是很合理的***/
    public static List<String> getMacList() throws Exception {
        java.util.Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
        StringBuilder sb = new StringBuilder();
        Set<String> tmpMacSet = new HashSet<>();
        while (en.hasMoreElements()) {
            NetworkInterface net = en.nextElement();
            List<InterfaceAddress> adders = net.getInterfaceAddresses();
            for (InterfaceAddress addr : adders) {
                InetAddress ip = addr.getAddress();
                NetworkInterface network = NetworkInterface.getByInetAddress(ip);
                if (network == null) {
                    continue;
                }
                byte[] mac = network.getHardwareAddress();
                if (mac == null) {
                    continue;
                }
                sb.delete(0, sb.length());
                for (int i = 0; i < mac.length; i++) {
                    sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
                }
                tmpMacSet.add(sb.toString());
            }
        }
        return new ArrayList<>(tmpMacSet);
    }
}
