/**
 * Copyright (c) 2018 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package cc.ehan.common.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 基础服务类，所有Service都要继承
 *
 * @author Mark sunlightcs@gmail.com
 */
public abstract class BaseServiceImpl<Mapper extends BaseMapper<Entity>, Entity> {
    @Autowired
    protected Mapper baseDao;

//    /**
//     * 开启分页查询
//     *
//     * @param pageQuery
//     */
//    protected void startPage(PageQuery pageQuery) {
//        if (Objects.nonNull(pageQuery) && Objects.nonNull(pageQuery.getPage()) && Objects.nonNull(pageQuery.getRows())) {
//            PageHelper.startPage(pageQuery.getPage(), pageQuery.getRows());
//        }
//    }
//
//
//    /**
//     * <p>
//     * 判断数据库操作是否成功
//     * </p>
//     * <p>
//     * 注意！！ 该方法为 Integer 判断，不可传入 int 基本类型
//     * </p>
//     *
//     * @param result 数据库操作返回影响条数
//     * @return boolean
//     */
//    protected static boolean retBool(Integer result) {
//        return SqlHelper.retBool(result);
//    }
//
//    protected Class<Entity> currentModelClass() {
//        return (Class<Entity>) ReflectionKit.getSuperClassGenericType(getClass(), 1);
//    }
//
//    /**
//     * <p>
//     * 批量操作 SqlSession
//     * </p>
//     */
//    protected SqlSession sqlSessionBatch() {
//        return SqlHelper.sqlSessionBatch(currentModelClass());
//    }
//
//    /**
//     * 释放sqlSession
//     *
//     * @param sqlSession session
//     */
//    protected void closeSqlSession(SqlSession sqlSession) {
//        SqlSessionUtils.closeSqlSession(sqlSession, GlobalConfigUtils.currentSessionFactory(currentModelClass()));
//    }
//
//    /**
//     * 获取SqlStatement
//     *
//     * @param sqlMethod
//     * @return
//     */
//    protected String sqlStatement(SqlMethod sqlMethod) {
//        return SqlHelper.table(currentModelClass()).getSqlStatement(sqlMethod.getMethod());
//    }
//
//    @Transactional(rollbackFor = Exception.class)
//    public boolean insert(Entity entity) {
//        return BaseServiceImpl.retBool(baseDao.insert(entity));
//    }
//
//    @Transactional(rollbackFor = Exception.class)
//    public boolean insertBatch(Collection<Entity> entityList) {
//        return insertBatch(entityList, batchSize);
//    }
//
//    /**
//     * 批量插入
//     *
//     * @param entityList
//     * @param batchSize
//     * @return
//     */
//    @Transactional(rollbackFor = Exception.class)
//    public boolean insertBatch(Collection<Entity> entityList, int batchSize) {
//        SqlSession batchSqlSession = sqlSessionBatch();
//        int i = 0;
//        String sqlStatement = sqlStatement(SqlMethod.INSERT_ONE);
//        try {
//            for (Entity anEntityList : entityList) {
//                batchSqlSession.insert(sqlStatement, anEntityList);
//                if (i >= 1 && i % batchSize == 0) {
//                    batchSqlSession.flushStatements();
//                }
//                i++;
//            }
//            batchSqlSession.flushStatements();
//        } finally {
//            closeSqlSession(batchSqlSession);
//        }
//        return true;
//    }
//
//    @Transactional(rollbackFor = Exception.class)
//    public boolean updateById(Entity entity) {
//        return BaseServiceImpl.retBool(baseDao.updateById(entity));
//    }
//
//    @Transactional(rollbackFor = Exception.class)
//    public void lockUpdateById(Entity entity) {
//        retLockBool(baseDao.updateById(entity));
//    }
//
//    @Transactional(rollbackFor = Exception.class)
//    public void lockUpdate(Entity entity, Wrapper<Entity> updateWrapper) {
//        retLockBool(baseDao.update(entity, updateWrapper));
//    }
//
//    public void retLockBool(int count) {
//        if (count == 0) {
//            throw new UnallowedException("操作失败");
//        }
//    }
//
//    public void retLockBool(boolean result) {
//        if (!result) {
//            throw new UnallowedException("操作失败");
//        }
//    }
//
//    @Transactional(rollbackFor = Exception.class)
//    public boolean update(Entity entity, Wrapper<Entity> updateWrapper) {
//        return BaseServiceImpl.retBool(baseDao.update(entity, updateWrapper));
//    }
//
//    @Transactional(rollbackFor = Exception.class)
//    public boolean updateBatchById(Collection<Entity> entityList) {
//        return updateBatchById(entityList, 30);
//    }
//
//    @Transactional(rollbackFor = Exception.class)
//    public boolean updateBatchById(Collection<Entity> entityList, int batchSize) {
//        if (CollectionUtils.isEmpty(entityList)) {
//            throw new IllegalArgumentException("Error: entityList must not be empty");
//        }
//        SqlSession batchSqlSession = sqlSessionBatch();
//        int i = 0;
//        String sqlStatement = sqlStatement(SqlMethod.UPDATE_BY_ID);
//        try {
//            for (Entity anEntityList : entityList) {
//                MapperMethod.ParamMap<Entity> param = new MapperMethod.ParamMap<>();
//                param.put("et", anEntityList);
//                batchSqlSession.update(sqlStatement, param);
//                if (i >= 1 && i % batchSize == 0) {
//                    batchSqlSession.flushStatements();
//                }
//                i++;
//            }
//            batchSqlSession.flushStatements();
//        } finally {
//            closeSqlSession(batchSqlSession);
//        }
//        return true;
//    }
//
//    public Entity selectEffectiveById(Serializable id) {
//        AssertUitls.notNull(id, "id is null");
//        Entity entity = selectById(id);
//        if (null == entity) {
//            throw new NullDataException("数据不存在");
//        }
//        return entity;
//    }
//
//    public Entity selectById(Serializable id) {
//        return baseDao.selectById(id);
//    }
//
//    public List<Entity> selectByIds(Serializable[] ids) {
//        return selectByIds(Arrays.asList(ids));
//    }
//
//    public List<Entity> selectByIds(Collection<Serializable> ids) {
//        return baseDao.selectBatchIds(ids);
//    }
//
//    @Transactional(rollbackFor = Exception.class)
//    public boolean deleteById(Serializable id) {
//        if (Objects.isNull(id)) {
//            return true;
//        }
//        return SqlHelper.retBool(baseDao.deleteById(id));
//    }
//
//    @Transactional(rollbackFor = Exception.class)
//    public boolean deleteBatchIds(Collection<? extends Serializable> idList) {
//        return SqlHelper.retBool(baseDao.deleteBatchIds(idList));
//    }
}