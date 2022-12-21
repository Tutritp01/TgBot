package com.tutrit.stoservice.bean;

import java.time.LocalDateTime;
import java.util.Objects;

public class Promo {

    private String id;
    private int discount;
    private String namePromo;
    private LocalDateTime timeStamp;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private User author;
    private PromoStatus status;

    public Promo() {
    }

    public Promo(String id, int discount, String namePromo, LocalDateTime timeStamp, LocalDateTime startDate, LocalDateTime endDate, User author, PromoStatus status) {
        this.id = id;
        this.discount = discount;
        this.namePromo = namePromo;
        this.timeStamp = timeStamp;
        this.startDate = startDate;
        this.endDate = endDate;
        this.author = author;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getNamePromo() {
        return namePromo;
    }

    public void setNamePromo(String namePromo) {
        this.namePromo = namePromo;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public PromoStatus getStatus() {
        return status;
    }

    public void setStatus(PromoStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Promo promo = (Promo) o;
        return discount == promo.discount && Objects.equals(id, promo.id) && Objects.equals(namePromo, promo.namePromo) && Objects.equals(timeStamp, promo.timeStamp) && Objects.equals(startDate, promo.startDate) && Objects.equals(endDate, promo.endDate) && Objects.equals(author, promo.author) && status == promo.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, discount, namePromo, timeStamp, startDate, endDate, author, status);
    }

    @Override
    public String toString() {
        return "Promo{" +
                "id='" + id + '\'' +
                ", discount=" + discount +
                ", namePromo='" + namePromo + '\'' +
                ", timeStamp=" + timeStamp +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", author=" + author +
                ", status=" + status +
                '}';
    }
}
