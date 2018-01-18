package cn.yearcon.sportwxservice.dao;

import cn.yearcon.sportwxservice.entity.SportsWx;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author itguang
 * @create 2017-12-04 14:30
 **/
public interface SportsWxRepository extends JpaRepository<SportsWx,Integer> {

    SportsWx findByWebid(Integer webid);
}
