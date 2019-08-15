package autointerface.demo.mybatis.mapper;

import autointerface.demo.mybatis.entity.MockDataInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MockDataInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MockDataInfo record);

    MockDataInfo selectByPrimaryKey(Integer id);

    List<MockDataInfo> selectAll();

    int updateByPrimaryKey(MockDataInfo record);

    @Select("SELECT * FROM mock_data_info WHERE business_path =#{businessPath}")
    MockDataInfo getByBusinessPath(@Param("businessPath") String businessPath);

    @Select("SELECT * FROM mock_data_info WHERE id =#{id}")
    MockDataInfo getById(@Param("id") Integer id);
}