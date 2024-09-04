package com.kj.springbasic.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kj.springbasic.entity.SampleUserEntity;

@Repository
public interface SampleUserRepository extends JpaRepository<SampleUserEntity, String> {

        // Query Method:
        // - Repository의 메서드 선언시에 지정된 패턴에 따라 메서드명을 작성하면 JPA가 SQL을 만들어주는 방법
        // - findBy : 필드명을 기준으로 모든 컬럼을 조회할 때 사용, findBy 뒤에 필드명을 붙여서 작성, 필드명의 첫 글자는
        // 대문자이어야함
        List<SampleUserEntity> findByName(String name);

        SampleUserEntity findByTelNumber(String telNumber);

        // - AND/OR : and 연산 혹은 or연산에 사용됨, 필드와 필드 사이에 사용
        // and/or 의 우선순위 주의
        List<SampleUserEntity> findByNameAndAddress(String name, String address);

        // - Like, NotLike, StartingWith, EndingWith, Containing: Like 연산에 대하여 사용, 필드 뒤에
        // 사용
        List<SampleUserEntity> findByAddressContaining(String address);

        // - OrderBy: 정렬을 사용할 필드를 지정하여 desc, asc 지정
        List<SampleUserEntity> findBynameOrderByTelNumberDesc(String name);

        // - existsBy: 조건에 해당하는 레코드가 존재하는지 여부 확인 시 사용
        boolean existsByname(String name);

        // - countBy: 조건에 해당하는 레코드의 개수 확인 시 사용
        int countByName(String name);

        // @Query:
        // - 쿼리 메서드의 한계를 극복하기 위해 사용하는 방식
        // - 쿼리 메서드가 사용할 수 없는 복잡한 쿼리를 직접 작성하는 방법

        // - JPQL (Java Persistence Query Language)
        // - 표준 SQL과 매우 흡사하지만 Entity 클래스와 Entity 필드로 쿼리를 작성하는 방법
        @Query(value = "SELECT u FROM user u WHERE u.name = ?1 AND u.address =?2")
        List<SampleUserEntity> getJpql(String name, String address);

        @Query(value = "SELECT u FROM user u WHERE u.name = :name AND u.address =:address")
        List<SampleUserEntity> getJpql2(
                        @Param("name") String name,
                        @Param("address") String address);

        // Native SQL:
        // - 현재 RDBMS의 SQL 문법을 그대로 사용하는 문법
        // - @Query nativeQuery 속성을 반드시 true로 지정
        @Query(value = "SELECT * " +
                        "FROM sample_user " +
                        "WHERE name = :name " +
                        "AND address = :address", nativeQuery = true)
        List<SampleUserEntity> getNativeSql(
                        @Param("name") String name,
                        @Param("address") String address);

        boolean existsByUserId(String UserId);
        boolean existsByTelNumber(String telNumber);

        SampleUserEntity findByUserId(String userId);
}
