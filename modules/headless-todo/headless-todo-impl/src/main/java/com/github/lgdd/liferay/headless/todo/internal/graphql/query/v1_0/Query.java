package com.github.lgdd.liferay.headless.todo.internal.graphql.query.v1_0;

import com.github.lgdd.liferay.headless.todo.dto.v1_0.Todo;
import com.github.lgdd.liferay.headless.todo.resource.v1_0.TodoResource;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import java.util.Map;
import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author lgd
 * @generated
 */
@Generated("")
public class Query {

	public static void setTodoResourceComponentServiceObjects(
		ComponentServiceObjects<TodoResource>
			todoResourceComponentServiceObjects) {

		_todoResourceComponentServiceObjects =
			todoResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {todos(filter: ___, page: ___, pageSize: ___, search: ___, sorts: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public TodoPage todos(
			@GraphQLName("search") String search,
			@GraphQLName("filter") String filterString,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_todoResourceComponentServiceObjects,
			this::_populateResourceContext,
			todoResource -> new TodoPage(
				todoResource.getTodosPage(
					search, _filterBiFunction.apply(todoResource, filterString),
					Pagination.of(page, pageSize),
					_sortsBiFunction.apply(todoResource, sortsString))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {todo(todoId: ___){id, title, status}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public Todo todo(@GraphQLName("todoId") Long todoId) throws Exception {
		return _applyComponentServiceObjects(
			_todoResourceComponentServiceObjects,
			this::_populateResourceContext,
			todoResource -> todoResource.getTodo(todoId));
	}

	@GraphQLName("TodoPage")
	public class TodoPage {

		public TodoPage(Page todoPage) {
			actions = todoPage.getActions();

			items = todoPage.getItems();
			lastPage = todoPage.getLastPage();
			page = todoPage.getPage();
			pageSize = todoPage.getPageSize();
			totalCount = todoPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Todo> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(TodoResource todoResource)
		throws Exception {

		todoResource.setContextAcceptLanguage(_acceptLanguage);
		todoResource.setContextCompany(_company);
		todoResource.setContextHttpServletRequest(_httpServletRequest);
		todoResource.setContextHttpServletResponse(_httpServletResponse);
		todoResource.setContextUriInfo(_uriInfo);
		todoResource.setContextUser(_user);
		todoResource.setGroupLocalService(_groupLocalService);
		todoResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<TodoResource>
		_todoResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private BiFunction<Object, String, Filter> _filterBiFunction;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}