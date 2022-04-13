package com.hrm.util;

import cn.hutool.core.date.DateUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.hrm.vo.StaffDeptVO;

import java.util.Date;

/**
 * Jwt工具类
 *
 * @Author : qiujie
 * @Date : 2022/1/30
 */
public class JWTUtil {

    /**
     * 生成登录令牌
     *
     * @param staffDeptVO
     * @return
     */
    public static String generateToken(StaffDeptVO staffDeptVO) {
        return JWT.create().withAudience(staffDeptVO.getId().toString()) // 设置载荷
                .withExpiresAt(DateUtil.offsetHour(new Date(), 1)) // 设置签名过期的时间
                .sign(Algorithm.HMAC256(staffDeptVO.getPassword())); // 签名 Signature
    }


}
