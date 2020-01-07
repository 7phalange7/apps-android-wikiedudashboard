package org.wikiedufoundation.wikiedudashboard.di

import org.koin.dsl.module
import org.wikiedufoundation.wikiedudashboard.ui.campaign.repository.ActiveCampaignRepository
import org.wikiedufoundation.wikiedudashboard.ui.campaign.dao.ActiveCampaignDao
import org.wikiedufoundation.wikiedudashboard.data.network.WikiEduDashboardApi

val repositoryModule = module {

    fun provideCampaignListRepository(api:WikiEduDashboardApi, activeCampaignDao: ActiveCampaignDao)
            : ActiveCampaignRepository = ActiveCampaignRepository(api, activeCampaignDao)

    single { provideCampaignListRepository(get(), get()) }
}
