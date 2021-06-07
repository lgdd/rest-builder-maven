package com.github.lgdd.liferay.headless.todo.internal.resource.v1_0;

import com.github.lgdd.liferay.headless.todo.dto.v1_0.Todo;
import com.github.lgdd.liferay.headless.todo.resource.v1_0.TodoResource;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author lgd
 */
@Component(
    properties = "OSGI-INF/liferay/rest/v1_0/todo.properties",
    scope = ServiceScope.PROTOTYPE,
    service = TodoResource.class
)
public class TodoResourceImpl
    extends BaseTodoResourceImpl {

  @Override
  public Page<Todo> getTodosPage(String search, Filter filter, Pagination pagination, Sort[] sorts)
      throws Exception {

    return Page.of(TODOS.values());
  }

  @Override
  public Todo postTodo(Todo todo)
      throws Exception {

    TODOS.put(counter.incrementAndGet(), todo);
    return todo;
  }

  @Override
  public Todo getTodo(Long todoId)
      throws Exception {

    return TODOS.get(todoId);
  }

  protected final AtomicLong counter = new AtomicLong(0);
  protected static final Map<Long, Todo> TODOS = new HashMap<>();

}