package com.yjy.beadhouse.dao;

import com.yjy.beadhouse.entity.Older;
import com.yjy.beadhouse.vo.OldVO;
import com.yjy.beadhouse.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OlderMapper {

    void addOlder(Older older);

    /**
     * 根据登录的用户ID获取老人信息
     * @param id
     * @return
     */

    Older getUserOlder(Integer id);

    /**
     * 获取护工所管理的所有老人信息
     */
    List<Older> getNurseOlderList(Integer id);


    /**
     * 根据老人ID获取老人信息
     * @param id
     * @return
     */
    Older getOlderById(Integer id);

    List<OldVO> getAllOlds();

    OldVO getOldVoById(Integer id);

    void modifyOld(Older older);

}
