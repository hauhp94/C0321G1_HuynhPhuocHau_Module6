package com.model.repository;

import com.dto.Statistic;
import com.model.entity.TicketMonth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StatisticRepository extends JpaRepository<TicketMonth, Integer> {
    @Query(nativeQuery = true,
            value = "select concat(month(time),'/',year(time)) as month, sum(total_prices) as service, sum(fee) as computer, (sum(total_prices) + sum(fee)) as total\n" +
                    "from order_detail\n" +
                    "join `order` on `order`.order_id = order_detail.order_id\n" +
                    "join customer on `order`.customer_id = customer.customer_id\n" +
                    "join account on customer.account_id = account.account_id\n" +
                    "join account_computer on account.account_id = account_computer.account_id\n" +
                    "join computer on account_computer.computer_id = computer.computer_id\n" +
                    "join category on account.category_id = category.category_id\n" +
                    "where (start_time > date(:startDate)) and (end_time < date(:endDate))\n" +
                    "group by month;")
    List<Statistic> getStatistic();
}
