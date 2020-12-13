package com.mongo.mongoaggregation.repository;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepositoryCustomImpl implements EmployeeRepositoryCustom {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public int getNumberOfEmployeeWithSalaryMoreThan(int salary) {
		MatchOperation matchOperation = Aggregation.match(Criteria.where("Salary").gte(salary));
		GroupOperation grpOperation = Aggregation.group().count().as("count");
		Aggregation aggrQuery = Aggregation.newAggregation(matchOperation, grpOperation);
		AggregationResults<Document> aggrResults = mongoTemplate.aggregate(aggrQuery, "employee", Document.class);
		int count = 0;
		for (Document doc : aggrResults) {
			count += doc.getInteger("count");
		}

		return count;
	}

	@Override
	public int getNumberOfEmployeeWithSalaryLessThan(int salary) {
		MatchOperation matchOperation = Aggregation.match(Criteria.where("Salary").lte(salary));
		GroupOperation grpOperation = Aggregation.group().count().as("count");
		Aggregation aggrQuery = Aggregation.newAggregation(matchOperation, grpOperation);
		AggregationResults<Document> aggrResults = mongoTemplate.aggregate(aggrQuery, "employee", Document.class);
		int count = 0;
		for (Document doc : aggrResults) {
			count += doc.getInteger("count");
		}

		return count;
	}

}
