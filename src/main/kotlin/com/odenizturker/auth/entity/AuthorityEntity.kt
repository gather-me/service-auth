package com.odenizturker.auth.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import org.springframework.security.core.GrantedAuthority

@Table("authorities")
class AuthorityEntity(
    @Id
    private val id: Long,
    private val authority: String
) : GrantedAuthority {
    override fun getAuthority(): String {
        return authority
    }
}
