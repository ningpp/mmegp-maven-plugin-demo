package me.ningpp.mmegp.demo.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import me.ningpp.mmegp.demo.entity.SysMenu;
import me.ningpp.mmegp.demo.entity.SysMenuExample;
import me.ningpp.mmegp.demo.entity.SysRole;
import me.ningpp.mmegp.demo.entity.SysRoleExample;
import me.ningpp.mmegp.demo.entity.SysRoleMenu;

/**
 * 
 * @author ningpp
 * @date 2021-08-26 13:42:45
 */
@Transactional
public interface AllService {
    void insertRole(SysRole role);

    void insertMenu(SysMenu menu);

    long insertRoleMenu(SysRoleMenu roleMenu);

    List<SysRole> getRoles(SysRoleExample roleExample);

    List<SysMenu> getMenus(SysMenuExample menuExample);

    List<SysRoleMenu> getRoleMenus(String roleId);

    void deleteRoleMenu(Long roleMenuId);
}
