package com.niit.recommendationservice.rabbitMQ;

import com.niit.recommendationservice.exceptions.CategoryAlreadyExistsException;
import com.niit.recommendationservice.exceptions.CategoryNotFoundException;
import com.niit.recommendationservice.exceptions.ServiceAlreadyExistsException;
import com.niit.recommendationservice.model.Category;
import com.niit.recommendationservice.model.Services;
import com.niit.recommendationservice.service.IRecoCategoryService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

public class Consumer {

    @Autowired
    private IRecoCategoryService recoCategoryService;

    @RabbitListener(queues = "salon-queue")
    public void addCategory(Category category) throws CategoryNotFoundException, ServiceAlreadyExistsException {
        System.out.println(category);
        Category category1 = new Category(category.getCategoryName(),category.getServices());
    }

}
