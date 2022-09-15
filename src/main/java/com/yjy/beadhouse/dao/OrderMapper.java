package com.yjy.beadhouse.dao;

import com.yjy.beadhouse.dto.AdminCreateOrderDTO;
import com.yjy.beadhouse.dto.CreateOrderDTO;
import com.yjy.beadhouse.entity.Older;
import com.yjy.beadhouse.entity.Order;
import com.yjy.beadhouse.vo.OrderVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {

    void createOrder(CreateOrderDTO createOrderDTO);

    List<Order> getOrderByUserId(Integer userId);

    void finishOrder(@Param("finishTime")String finishTime,@Param("id")Integer id);

    List<OrderVO> getAllOrder();

    void adminCreateOrder(AdminCreateOrderDTO dto);

    void delOrder(Integer id);

}
