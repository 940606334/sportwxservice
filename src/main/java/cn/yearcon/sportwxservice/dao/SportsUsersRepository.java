package cn.yearcon.sportwxservice.dao;

import cn.yearcon.sportwxservice.entity.SportsUsers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SportsUsersRepository extends CrudRepository<SportsUsers,Integer>{
    SportsUsers findByOpenid(@Param("openid") String openid);
}
