package com.example.magikotov.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="images")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="originalFileName")
    private String originalFileName;
    @Column(name="size")
    private Long size;
    @Column(name="contentType")
    private String contentType;
    @Column(name="isOPreviewImage")
    private  boolean isOPreviewImage;
    @Lob
    @Column(name= "bytes", columnDefinition = "longblog")
    private byte[]bytes;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Product product;



}
