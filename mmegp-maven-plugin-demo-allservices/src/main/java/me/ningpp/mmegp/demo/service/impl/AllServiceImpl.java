package me.ningpp.mmegp.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.ningpp.mmegp.demo.entity.SysMenu;
import me.ningpp.mmegp.demo.entity.SysMenuExample;
import me.ningpp.mmegp.demo.entity.SysRole;
import me.ningpp.mmegp.demo.entity.SysRoleExample;
import me.ningpp.mmegp.demo.entity.SysRoleMenu;
import me.ningpp.mmegp.demo.entity.SysRoleMenuExample;
import me.ningpp.mmegp.demo.mapper.SysMenuMapper;
import me.ningpp.mmegp.demo.mapper.SysRoleMapper;
import me.ningpp.mmegp.demo.mapper.SysRoleMenuMapper;
import me.ningpp.mmegp.demo.service.AllService;

/**
 * 
 * @author ningpp
 * @date 2021-08-26 13:49:06
 */
@Service
public class AllServiceImpl implements AllService {

    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;
    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public void insertRole(SysRole role) {
        sysRoleMapper.insert(role);
    }

    @Override
    public void insertMenu(SysMenu menu) {
        sysMenuMapper.insert(menu);
    }

    @Override
    public long insertRoleMenu(SysRoleMenu roleMenu) {
        sysRoleMenuMapper.insert(roleMenu);
        return roleMenu.getId();
    }

    @Override
    public List<SysRole> getRoles(SysRoleExample roleExample) {
        return sysRoleMapper.selectByExample(roleExample);
    }

    @Override
    public List<SysMenu> getMenus(SysMenuExample menuExample) {
        return sysMenuMapper.selectByExample(menuExample);
    }

    @Override
    public List<SysRoleMenu> getRoleMenus(String roleId) {
        SysRoleMenuExample roleMenuExample = new SysRoleMenuExample();
        roleMenuExample.createCriteria().andRoleIdEqualTo(roleId);
        return sysRoleMenuMapper.selectByExample(roleMenuExample);
    }

    @Override
    public void deleteRoleMenu(Long roleMenuId) {
        sysRoleMenuMapper.deleteByPrimaryKey(roleMenuId);
    }

}
