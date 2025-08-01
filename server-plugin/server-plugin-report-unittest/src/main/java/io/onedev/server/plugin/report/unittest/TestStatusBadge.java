package io.onedev.server.plugin.report.unittest;

import static io.onedev.server.web.translation.Translation._T;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.AbstractReadOnlyModel;

import io.onedev.server.plugin.report.unittest.UnitTestReport.Status;
import io.onedev.server.web.util.TextUtils;

class TestStatusBadge extends Label {
	
	private final Status status;
	
	public TestStatusBadge(String id, Status status) {
		super(id, _T(TextUtils.getDisplayValue(status)));
		this.status = status;
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		
		add(AttributeAppender.append("class", new AbstractReadOnlyModel<String>() {

			@Override
			public String getObject() {
				switch (status) {
					case PASSED:
						return "unit-test-status badge badge-success flex-shrink-0";
					case NOT_PASSED:
						return "unit-test-status badge badge-danger flex-shrink-0";
					case OTHER:
						return "unit-test-status badge badge-warning flex-shrink-0";
					case NOT_RUN:
						return "unit-test-status badge badge-info flex-shrink-0";
					default:
						throw new RuntimeException("Unexpected unit test status: " + status);
				}
			}
			
		}));
	}

}
