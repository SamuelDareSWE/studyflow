package com.studyflow.studyflow_backend.task.specification;

import com.studyflow.studyflow_backend.common.enums.TaskPriority;
import com.studyflow.studyflow_backend.task.entity.Task;
import org.springframework.data.jpa.domain.Specification;

public class TaskSpecification {

    public static Specification<Task> hasCompletedStatus(Boolean completed) {

        return (root, query, criteriaBuilder) ->
                completed == null
                        ? null
                        : criteriaBuilder.equal(root.get("completed"), completed);

    }

    public static Specification<Task> isNotDeleted() {
        return (root, query, criteriaBuilder) -> criteriaBuilder.isFalse(root.get("deleted"));
    }

    public static Specification<Task> hasPriority(TaskPriority priority) {

        return (root, query, criteriaBuilder) ->
                priority == null
                        ? null : criteriaBuilder.equal(root.get("priority"), priority);

    }

    public static Specification<Task> hasCourseId(Long courseId) {

        return (root, query, criteriaBuilder) ->
                courseId == null
                        ? null
                        : criteriaBuilder.equal(
                                root.get("course").get("id"), courseId);

    }

}
