package com.odenizturker.auth.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Table("user")
class UserEntity(
    @Id
    private val id: Long? = null,
    private val firstName: String,
    private val secondName: String,
    private val username: String,
    private val emailAddress: String,
    private val password: String,
    private val registrationCompleted: Boolean = false,
    private val expired: Boolean = false,
    private val locked: Boolean = false,
    private val credentialsExpired: Boolean = false,
    private val enabled: Boolean = true
) : UserDetails {
    override fun getAuthorities(): Set<GrantedAuthority> {
        return setOf()
    }

    override fun getPassword(): String {
        return password
    }

    override fun getUsername(): String {
        return id.toString()
    }

    override fun isAccountNonExpired(): Boolean {
        return !expired
    }

    override fun isAccountNonLocked(): Boolean {
        return !locked
    }

    override fun isCredentialsNonExpired(): Boolean {
        return !credentialsExpired
    }

    override fun isEnabled(): Boolean {
        return enabled
    }
}
