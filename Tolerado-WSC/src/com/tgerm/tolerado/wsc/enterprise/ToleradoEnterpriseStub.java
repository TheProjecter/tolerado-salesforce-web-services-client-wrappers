/*
Copyright (c) 2010 tgerm.com
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions
are met:

1. Redistributions of source code must retain the above copyright
   notice, this list of conditions and the following disclaimer.
2. Redistributions in binary form must reproduce the above copyright
   notice, this list of conditions and the following disclaimer in the
   documentation and/or other materials provided with the distribution.
3. The name of the author may not be used to endorse or promote products
   derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE AUTHOR "AS IS" AND ANY EXPRESS OR
IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT, 
INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.tgerm.tolerado.wsc.enterprise;

import com.sforce.soap.enterprise.DeleteResult;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.LoginResult;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.SaveResult;
import com.sforce.soap.enterprise.sobject.SObject;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;
import com.tgerm.tolerado.wsc.core.Credential;
import com.tgerm.tolerado.wsc.core.ToleradoException;
import com.tgerm.tolerado.wsc.core.ToleradoStub;
import com.tgerm.tolerado.wsc.core.method.WSRecoverableMethod;

/**
 * {@link ToleradoEnterpriseStub} for Enterprise WSDL
 * 
 * @author abhinav
 * 
 */
public class ToleradoEnterpriseStub extends ToleradoStub {
	private EnterpriseConnection binding;

	public ToleradoEnterpriseStub(Credential cred) {
		super(cred, new EnterpriseLoginDriver());
	}

	/**
	 * @return The {@link SoapBindingStub} for partner wsdl
	 */
	public EnterpriseConnection getEnterpriseBinding() {
		return binding;
	}

	@Override
	public void prepare(boolean forceNew) {
		super.prepare(forceNew);
		// Create Enterprise Connection
		ConnectorConfig entCfg = new ConnectorConfig();
		entCfg.setManualLogin(true);
		// Enterprise Service Endpoint used from WSCSession
		entCfg.setServiceEndpoint(session.getEnterpriseServerUrl());
		// SFDC Session Id pulled from WSCSession
		entCfg.setSessionId(session.getSessionId());
		try {
			binding = com.sforce.soap.enterprise.Connector
					.newConnection(entCfg);
		} catch (ConnectionException e) {
			throw new ToleradoException(
					"Failed to instantiate EnterpriseConnection, user:"
							+ credential.getUserName(), e);
		}
	}

	/**
	 * Gives the salesforce login result
	 * 
	 */
	public LoginResult getLoginResult() {
		return (LoginResult) session.getLoginResult();
	}

	/**
	 * Queries salesforce via SOQL
	 * 
	 * @param soql
	 * @return
	 */
	public QueryResult query(final String soql) {
		WSRecoverableMethod<QueryResult, ToleradoEnterpriseStub> wsMethod = new WSRecoverableMethod<QueryResult, ToleradoEnterpriseStub>(
				"Query") {
			@Override
			protected QueryResult invokeActual(ToleradoEnterpriseStub stub)
					throws Exception {
				QueryResult query = stub.getEnterpriseBinding().query(soql);
				return query;
			}
		};
		return wsMethod.invoke(this);
	}

	public QueryResult queryAll(final String soql) {
		return new WSRecoverableMethod<QueryResult, ToleradoEnterpriseStub>(
				"QueryAll") {
			@Override
			protected QueryResult invokeActual(ToleradoEnterpriseStub stub)
					throws Exception {
				QueryResult query = stub.getEnterpriseBinding().queryAll(soql);
				return query;
			}
		}.invoke(this);
	}

	public QueryResult queryMore(final String queryLocator) {
		return new WSRecoverableMethod<QueryResult, ToleradoEnterpriseStub>(
				"QueryMore") {
			@Override
			protected QueryResult invokeActual(ToleradoEnterpriseStub stub)
					throws Exception {
				QueryResult query = stub.getEnterpriseBinding().queryMore(
						queryLocator);
				return query;
			}
		}.invoke(this);
	}

	public DeleteResult[] delete(final String[] ids) {
		return new WSRecoverableMethod<DeleteResult[], ToleradoEnterpriseStub>(
				"delete") {
			@Override
			protected DeleteResult[] invokeActual(ToleradoEnterpriseStub stub)
					throws Exception {
				DeleteResult[] results = stub.getEnterpriseBinding()
						.delete(ids);
				return results;
			}
		}.invoke(this);
	}

	public SaveResult[] create(final SObject[] sObjects) {
		return new WSRecoverableMethod<SaveResult[], ToleradoEnterpriseStub>(
				"create") {
			@Override
			protected SaveResult[] invokeActual(ToleradoEnterpriseStub stub)
					throws Exception {
				return stub.getEnterpriseBinding().create(sObjects);
			}
		}.invoke(this);
	}

	public SaveResult[] update(final SObject[] sObjects) {
		return new WSRecoverableMethod<SaveResult[], ToleradoEnterpriseStub>(
				"update") {
			@Override
			protected SaveResult[] invokeActual(ToleradoEnterpriseStub stub)
					throws Exception {
				return stub.getEnterpriseBinding().update(sObjects);
			}
		}.invoke(this);
	}
}
