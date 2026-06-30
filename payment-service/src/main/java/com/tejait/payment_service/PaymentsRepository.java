package com.tejait.payment_service;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentsRepository extends JpaRepository<Payment,Integer> {
}
