package com.example.blog.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "users")
class User(
    @Id @GeneratedValue var id: Long? = null,
    var firstname: String,
    var lastname: String,
    var description: String? = null
) {

    fun update(firstname: String, lastname: String, description: String?) {
        this.firstname = firstname
        this.lastname = lastname
        this.description = description
    }
}