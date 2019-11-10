package com.example.newsanchor

import com.example.newsanchor.helpers.enums.NotificationType
import com.example.newsanchor.helpers.enums.YourTaskType
import com.example.newsanchor.models.*

/**
 * Created by K.I Prihan Nimsara on 2019-11-06.
 */

fun generateProjects(): List<ProjectModel> {
    return listOf<ProjectModel>(
        ProjectModel(
            "The Hitchhiker's Guide to the Galaxy ",
            "80",
            "Arabian Peninsula",
            "Ongoing",
            "500000",
            "https://cdn.pixabay.com/photo/2015/07/28/20/55/tools-864983_960_720.jpg"
        ),
        ProjectModel(
            "The Curious Incident of the Dog in the Night-Time",
            "100",
            "Subacvintos",
            "Completed",
            "120000",
            "https://images.unsplash.com/photo-1482731215275-a1f151646268?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80"
        ),
        ProjectModel(
            "Something Wicked This Way Comes",
            "50",
            "Withermarsh",
            "Pending",
            "1000000",
            "https://cdn.pixabay.com/photo/2017/03/27/11/19/welding-2178127_960_720.jpg"
        ),
        ProjectModel(
            "The Hitchhiker's Guide to the Galaxy ",
            "80",
            "Arabian Peninsula",
            "Ongoing",
            "500000",
            "https://images.unsplash.com/reserve/oIpwxeeSPy1cnwYpqJ1w_Dufer%20Collateral%20test.jpg?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1216&q=80"
        ),
        ProjectModel(
            "Something Wicked This Way Comes",
            "50",
            "Withermarsh",
            "Pending",
            "1000000",
            "https://images.unsplash.com/photo-1498631906572-66c58d46ecf7?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1448&q=80"
        ),
        ProjectModel(
            "The Curious Incident of the Dog in the Night-Time",
            "100",
            "Subacvintos",
            "Completed",
            "120000",
            "https://images.unsplash.com/photo-1494067329533-4385a4867cd4?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80"
        ),
        ProjectModel(
            "The Hitchhiker's Guide to the Galaxy ",
            "80",
            "Arabian Peninsula",
            "Ongoing",
            "500000",
            "https://images.unsplash.com/photo-1535732759880-bbd5c7265e3f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2000&q=80"
        ),
        ProjectModel(
            "Something Wicked This Way Comes",
            "50",
            "Withermarsh",
            "Pending",
            "1000000",
            "https://images.unsplash.com/photo-1504917595217-d4dc5ebe6122?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1950&q=80"
        ),
        ProjectModel(
            "The Curious Incident of the Dog in the Night-Time",
            "100",
            "Subacvintos",
            "Completed",
            "120000",
            "https://images.unsplash.com/photo-1482731215275-a1f151646268?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80"
        ),
        ProjectModel(
            "The Hitchhiker's Guide to the Galaxy ",
            "80",
            "Arabian Peninsula",
            "Ongoing",
            "500000",
            "https://images.unsplash.com/reserve/oIpwxeeSPy1cnwYpqJ1w_Dufer%20Collateral%20test.jpg?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1216&q=80"
        ),
        ProjectModel(
            "Something Wicked This Way Comes",
            "50",
            "Withermarsh",
            "Pending",
            "1000000",
            "https://images.unsplash.com/photo-1498631906572-66c58d46ecf7?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1448&q=80"
        ),
        ProjectModel(
            "The Curious Incident of the Dog in the Night-Time",
            "100",
            "Subacvintos",
            "Completed",
            "120000",
            "https://images.unsplash.com/photo-1494067329533-4385a4867cd4?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80"
        )
    )
}

fun generateYourTasks(type: YourTaskType): List<YourTaskModel> {
    val data = listOf(
        YourTaskModel(
            "Results of laboratory analysis",
            "Image",
            "https://images.unsplash.com/photo-1492540747731-d05a66dc2461?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=200&q=80",
            "Mohommed Biola",
            "10 Sept 2019",
            false
        ),
        YourTaskModel(
            "Get people info",
            "Survey",
            "https://images.unsplash.com/photo-1506919258185-6078bba55d2a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=200&q=80",
            "Selma Donald",
            "15 Sept 2019",
            false
        ),
        YourTaskModel(
            "What are the things used",
            "Quiz",
            "https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=200&q=80",
            "Tuyet Rozell",
            "21 Sept 2019",
            false
        ),
        YourTaskModel(
            "How much do you follow the news",
            "Image",
            "https://images.unsplash.com/photo-1494790108377-be9c29b29330?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80",
            "Spring Schipper",
            "01 Nov 2020",
            false
        ),
        YourTaskModel(
            "What gets too much attention in the news",
            "Survey",
            "https://images.unsplash.com/photo-1505503693641-1926193e8d57?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=200&q=80",
            "Lorena Hruska",
            "08 Dec 2018",
            true
        ),
        YourTaskModel(
            "Get people info",
            "Survey",
            "https://images.unsplash.com/photo-1496840220025-4cbde0b9df65?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=200&q=80",
            "Roberta Sagers",
            "10 Dec 2018",
            true
        ),
        YourTaskModel(
            "Results of laboratory analysis",
            "Image",
            "https://images.unsplash.com/photo-1492540747731-d05a66dc2461?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=200&q=80",
            "Mohommed Biola",
            "10 Nov 2019",
            false
        ),
        YourTaskModel(
            "Get people info",
            "Survey",
            "https://images.unsplash.com/photo-1506919258185-6078bba55d2a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=200&q=80",
            "Selma Donald",
            "08 Dec 2019",
            false
        ),
        YourTaskModel(
            "What gets too much attention in the news",
            "Survey",
            "https://images.unsplash.com/photo-1505503693641-1926193e8d57?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=200&q=80",
            "Lorena Hruska",
            "18 Dec 2018",
            true
        )
    )

    val result: List<YourTaskModel>
    result = if (type == YourTaskType.TODO) {
        data.filter { d -> !d.isSubmitted }
    } else {
        data.filter { d -> d.isSubmitted }
    }

    return result
}

fun generateMCQ(): List<MCQModel> {
    return listOf(
        MCQModel(
            "Are you satisfied with the participation and support of the community members?",
            true
        ),
        MCQModel("Has the first phase of the project been completed?", true),
        MCQModel("Any wastage found during the evaluation?", true)
    )
}

fun generateQuiz(): List<QuizModel> {
    return listOf(
        QuizModel("Are you satisfied with the participation and support of the community members?"),
        QuizModel("Has the first phase of the project been completed?"),
        QuizModel("Any wastage found during the evaluation?")
    )
}

fun generateWallet(): List<WalletModel> {
    return listOf(
        WalletModel("Personal Wallet", "XML", "#369C05", "#074B9F", "5400"),
        WalletModel("K-Dere Oil Spill Cleanup", "PST", "#156EDC", "#0A2C56", "5341.99"),
        WalletModel(
            "World Bank Rural Electrification Project",
            "PST",
            "#156EDC",
            "#0A2C56",
            "2541.99"
        )
    )
}

fun generateTransactions(): List<TransactionHistoryModel> {
    return listOf(
        TransactionHistoryModel(
            "Tamara Stevens",
            "1232.92",
            "PST",
            "Earn",
            "10 Apr 2019",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            "https://images.unsplash.com/photo-1496840220025-4cbde0b9df65?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=200&q=80"
        ),
        TransactionHistoryModel(
            "Dexter Dalton",
            "400",
            "PST",
            "Earn",
            "12 Jul 2019",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            "https://images.unsplash.com/photo-1505503693641-1926193e8d57?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=200&q=80"
        ),
        TransactionHistoryModel(
            "Anya Alvarado",
            "1002",
            "PST",
            "Withdraw",
            "12 Jul 2019",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            "https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=200&q=80"
        ),
        TransactionHistoryModel(
            "Tamara Stevens",
            "1232.92",
            "PST",
            "Earn",
            "10 Apr 2019",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            "https://images.unsplash.com/photo-1496840220025-4cbde0b9df65?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=200&q=80"
        ),
        TransactionHistoryModel(
            "Dexter Dalton",
            "400",
            "PST",
            "Earn",
            "12 Jul 2019",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            "https://images.unsplash.com/photo-1505503693641-1926193e8d57?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=200&q=80"
        ),
        TransactionHistoryModel(
            "Anya Alvarado",
            "1002",
            "PST",
            "Withdraw",
            "12 Jul 2019",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            "https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=200&q=80"
        ),
        TransactionHistoryModel(
            "Tamara Stevens",
            "1232.92",
            "PST",
            "Earn",
            "10 Apr 2019",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            "https://images.unsplash.com/photo-1496840220025-4cbde0b9df65?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=200&q=80"
        ),
        TransactionHistoryModel(
            "Dexter Dalton",
            "400",
            "PST",
            "Earn",
            "12 Jul 2019",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            "https://images.unsplash.com/photo-1505503693641-1926193e8d57?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=200&q=80"
        ),
        TransactionHistoryModel(
            "Anya Alvarado",
            "1002",
            "PST",
            "Withdraw",
            "12 Jul 2019",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            "https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=200&q=80"
        )
    )
}

fun generateUserInterests(): List<UserInterestModel>{
    return listOf(
        UserInterestModel("1", true),
        UserInterestModel("2", true),
        UserInterestModel("8", true),
        UserInterestModel("9", true),
        UserInterestModel("12", true),
        UserInterestModel("13", true),
        UserInterestModel("17", true)
    )
}

fun generateNotifications(): List<NotificationModel>{
    return listOf(
        NotificationModel("You’ve been assigned 2 new tasks.", "2019-08-27T12:08:56.235","", NotificationType.NEW_TASK),
        NotificationModel("Joseph commented on your task.", "2019-08-26T18:08:56.235","", NotificationType.COMMENT),
        NotificationModel("You’ve received funds in your wallet.", "2019-08-26T23:08:56.235","", NotificationType.FUNDS),
        NotificationModel("You’ve been assigned 2 new tasks.", "2019-08-26T12:08:56.235","", NotificationType.NEW_TASK),
        NotificationModel("Calsy Carpentor commented on your task.", "2019-07-02T12:08:56.235","", NotificationType.COMMENT),
        NotificationModel("Minoli commented on your task.", "2019-06-04T12:08:56.235","", NotificationType.COMMENT),
        NotificationModel("You’ve been assigned 2 new tasks.", "2018-12-04T12:08:56.235","", NotificationType.NEW_TASK),
        NotificationModel("You’ve received funds in your wallet.", "2018-08-04T12:08:56.235","", NotificationType.FUNDS)
    )
}

fun generateOnboardings(): List<OnboardingModel>{
    return listOf(
        OnboardingModel("Fund", "Find, fund and track development projects in the emerging world. See how your contribution impacts the UN's Sustainable Development Goals.", R.drawable.image_onboarding_fund),
        OnboardingModel("Execute", "Execute development projects with transparency and impact-driven measurements.", R.drawable.image_onboarding_execute),
        OnboardingModel("Evaluate", "Evaluate the progress of development projects within the community. Become an active participate in leading change through accountability.", R.drawable.image_onboarding_evaluate)
    )
}