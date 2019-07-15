package br.gov.df.pm.sgpol.sgpol.api

import br.gov.df.pm.sgpol.sgpol.model.RepositoryDetail
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import rx.Observable

interface ApiService {


    @GET(ApiSettings.ORGANIZATION_REPOS)
    fun getOrganizationRepos(@Path(ApiSettings.PATH_ORGANIZATION) organizationName: String,
                             @Query(ApiSettings.PARAM_REPOS_TYPE) reposType: String): Observable<MutableList<RepositoryDetail>>

    @GET(ApiSettings.REPOSITORY)
    fun getRepository(@Path(ApiSettings.PATH_OWNER) owner: String,
                      @Path(ApiSettings.PATH_REPO) name: String): Observable<RepositoryDetail>
}