package com.lin.bootdemo.common.handler;


import com.lin.bootdemo.enumcode.BaseEnum;
import com.lin.bootdemo.utils.CodeEnumUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author gd
 * @Date 2019/11/27 20:58
 * @Description work region type handler
 */
@MappedTypes({BaseEnum.class})
public class CommonEnumHandler<E extends Enum<E> & BaseEnum> extends BaseTypeHandler<E> {

    private static final Logger logger= LoggerFactory.getLogger(CommonEnumHandler.class);

    private final Class<E> type;

    public CommonEnumHandler(Class<E> type) {
        this.type = type;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i,parameter.getCode());
    }

    @Override
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int code = rs.getInt(columnName);
        return rs.wasNull() ? null : codeOf(code);
    }

    @Override
    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int code = rs.getInt(columnIndex);
        return rs.wasNull() ? null : codeOf(code);
    }

    @Override
    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int code = cs.getInt(columnIndex);
        return cs.wasNull() ? null : codeOf(code);
    }

    private E codeOf(int code)
    {
        try
        {
           return CodeEnumUtils.codeOf(type,code);
        }catch (Exception e)
        {
            logger.error("can not convert {} to {}",code,type.getSimpleName());
        }
        return null;
    }
}
