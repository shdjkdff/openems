package io.openems.edge.ess.refu88k;

import io.openems.common.channel.AccessMode;
import io.openems.common.channel.Level;
import io.openems.common.channel.Unit;
import io.openems.common.types.OpenemsType;
import io.openems.edge.common.channel.ChannelId;
import io.openems.edge.common.channel.Doc;
import io.openems.edge.ess.refu88k.enums.Conn;
import io.openems.edge.ess.refu88k.enums.DerTyp;
import io.openems.edge.ess.refu88k.enums.LocRemCtl;
import io.openems.edge.ess.refu88k.enums.OperatingState;
import io.openems.edge.ess.refu88k.enums.OutPFSetEna;
import io.openems.edge.ess.refu88k.enums.PCSSetOperation;
import io.openems.edge.ess.refu88k.enums.VArPctEna;
import io.openems.edge.ess.refu88k.enums.VendorOperatingState;
import io.openems.edge.ess.refu88k.enums.WMaxLimEna;

public enum REFUStore88KChannelId implements ChannelId {
	BAT_MIN_CELL_VOLTAGE(Doc.of(OpenemsType.INTEGER) //
			.unit(Unit.MILLIVOLT)),
	BAT_VOLTAGE(Doc.of(OpenemsType.INTEGER) //
			.unit(Unit.VOLT)),
	BAT_TEMP(Doc.of(OpenemsType.INTEGER) //
			.accessMode(AccessMode.WRITE_ONLY) //
			.unit(Unit.DEGREE_CELSIUS)),
	BAT_SOC(Doc.of(OpenemsType.INTEGER) //
			.accessMode(AccessMode.WRITE_ONLY) //
			.unit(Unit.PERCENT)),
	BAT_SOH(Doc.of(OpenemsType.INTEGER) //
			.accessMode(AccessMode.WRITE_ONLY) //
			.unit(Unit.PERCENT)), //
	/*
	 * Model SUNSPEC_1 (Common)
	 */
	ID_1(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //
	L_1(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //
	MN(Doc.of(OpenemsType.STRING).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //
	MD(Doc.of(OpenemsType.STRING).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //
	OPT(Doc.of(OpenemsType.STRING).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //
	VR(Doc.of(OpenemsType.STRING).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //
	SN(Doc.of(OpenemsType.STRING).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //
	DA(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_WRITE)), //
	PAD_1(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //

	/*
	 * Model SUNSPEC_103 (Inverter Three Phase)
	 */
	ID_103(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //
	L_103(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //
	A(Doc.of(OpenemsType.INTEGER).unit(Unit.AMPERE).accessMode(AccessMode.READ_ONLY)), //
	APH_A(Doc.of(OpenemsType.INTEGER).unit(Unit.AMPERE).accessMode(AccessMode.READ_ONLY)), //
	APH_B(Doc.of(OpenemsType.INTEGER).unit(Unit.AMPERE).accessMode(AccessMode.READ_ONLY)), //
	APH_C(Doc.of(OpenemsType.INTEGER).unit(Unit.AMPERE).accessMode(AccessMode.READ_ONLY)), //
	A_SF(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //
	PP_VPH_AB(Doc.of(OpenemsType.INTEGER).unit(Unit.VOLT).accessMode(AccessMode.READ_ONLY)), //
	PP_VPH_BC(Doc.of(OpenemsType.INTEGER).unit(Unit.VOLT).accessMode(AccessMode.READ_ONLY)), //
	PP_VPH_CA(Doc.of(OpenemsType.INTEGER).unit(Unit.VOLT).accessMode(AccessMode.READ_ONLY)), //
	PH_VPH_A(Doc.of(OpenemsType.INTEGER).unit(Unit.VOLT).accessMode(AccessMode.READ_ONLY)), //
	PH_VPH_B(Doc.of(OpenemsType.INTEGER).unit(Unit.VOLT).accessMode(AccessMode.READ_ONLY)), //
	PH_VPH_C(Doc.of(OpenemsType.INTEGER).unit(Unit.VOLT).accessMode(AccessMode.READ_ONLY)), //
	V_SF(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //
	W_SF(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //
	HZ(Doc.of(OpenemsType.INTEGER).unit(Unit.HERTZ).accessMode(AccessMode.READ_ONLY)), //
	HZ_SF(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //
	VA(Doc.of(OpenemsType.INTEGER).unit(Unit.VOLT_AMPERE).accessMode(AccessMode.READ_ONLY)), //
	VA_SF(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //
	VA_R(Doc.of(OpenemsType.INTEGER).unit(Unit.VOLT_AMPERE_REACTIVE).accessMode(AccessMode.READ_ONLY)), //
	VA_R_SF(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //
	WH(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //
	WH_SF(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //
	DCA(Doc.of(OpenemsType.INTEGER).unit(Unit.AMPERE).accessMode(AccessMode.READ_ONLY)), //
	DCA_SF(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //
	DCV(Doc.of(OpenemsType.INTEGER).unit(Unit.VOLT).accessMode(AccessMode.READ_ONLY)), //
	DCV_SF(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //
	DCW(Doc.of(OpenemsType.INTEGER).unit(Unit.WATT).accessMode(AccessMode.READ_ONLY)), //
	DCW_SF(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //
	TMP_CAB(Doc.of(OpenemsType.INTEGER).unit(Unit.DEGREE_CELSIUS).accessMode(AccessMode.READ_ONLY)), //
	TMP_SNK(Doc.of(OpenemsType.INTEGER).unit(Unit.DEGREE_CELSIUS).accessMode(AccessMode.READ_ONLY)), //
	TMP_SF(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //
	ST(Doc.of(OperatingState.values())), //
	ST_VND(Doc.of(VendorOperatingState.values())), //
	// Evt1 Alarms and Warnings
	GROUND_FAULT(Doc.of(Level.FAULT) //
			.text("Ground fault")), //
	DC_OVER_VOLTAGE(Doc.of(Level.FAULT) //
			.text("Dc over voltage")), //
	AC_DISCONNECT(Doc.of(Level.FAULT) //
			.text("AC disconnect open")), //
	DC_DISCONNECT(Doc.of(Level.FAULT) //
			.text("DC disconnect open")), //
	GRID_DISCONNECT(Doc.of(Level.FAULT) //
			.text("Grid shutdown")), //
	CABINET_OPEN(Doc.of(Level.FAULT) //
			.text("Cabinet open")), //
	MANUAL_SHUTDOWN(Doc.of(Level.FAULT) //
			.text("Manual shutdown")), //
	OVER_TEMP(Doc.of(Level.FAULT) //
			.text("Over temperature")), //
	OVER_FREQUENCY(Doc.of(Level.FAULT) //
			.text("Frequency above limit")), //
	UNDER_FREQUENCY(Doc.of(Level.FAULT) //
			.text("Frequency under limit")), //
	AC_OVER_VOLT(Doc.of(Level.FAULT) //
			.text("AC Voltage above limit")), //
	AC_UNDER_VOLT(Doc.of(Level.FAULT) //
			.text("AC Voltage under limit")), //
	BLOWN_STRING_FUSE(Doc.of(Level.FAULT) //
			.text("Blown String fuse on input")), //
	UNDER_TEMP(Doc.of(Level.FAULT) //
			.text("Under temperature")), //
	MEMORY_LOSS(Doc.of(Level.FAULT) //
			.text("Generic Memory or Communication error (internal)")), //
	HW_TEST_FAILURE(Doc.of(Level.FAULT) //
			.text("Hardware test failure")), //
	OTHER_ALARM(Doc.of(Level.FAULT) //
			.text("Other alarm")), //
	OTHER_WARNING(Doc.of(Level.FAULT) //
			.text("Other warning")), //
	EVT_2(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //
	EVT_VND_1(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //
	EVT_VND_2(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //
	EVT_VND_3(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //
	EVT_VND_4(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //

	/*
	 * Model SUNSPEC_120 (Inverter Controls Nameplate Ratings)
	 */
	ID_120(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //
	L_120(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //
	DER_TYP(Doc.of(DerTyp.values())), //
	W_RTG(Doc.of(OpenemsType.INTEGER).unit(Unit.WATT).accessMode(AccessMode.READ_ONLY)), //
	W_RTG_SF(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //
	VA_RTG(Doc.of(OpenemsType.INTEGER).unit(Unit.VOLT_AMPERE).accessMode(AccessMode.READ_ONLY)), //
	VA_RTG_SF(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //
	VAR_RTG_Q1(Doc.of(OpenemsType.INTEGER).unit(Unit.VOLT_AMPERE_REACTIVE).accessMode(AccessMode.READ_ONLY)), //
	VAR_RTG_Q2(Doc.of(OpenemsType.INTEGER).unit(Unit.VOLT_AMPERE_REACTIVE).accessMode(AccessMode.READ_ONLY)), //
	VAR_RTG_Q3(Doc.of(OpenemsType.INTEGER).unit(Unit.VOLT_AMPERE_REACTIVE).accessMode(AccessMode.READ_ONLY)), //
	VAR_RTG_Q4(Doc.of(OpenemsType.INTEGER).unit(Unit.VOLT_AMPERE_REACTIVE).accessMode(AccessMode.READ_ONLY)), //
	VAR_RTG_SF(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //
	A_RTG(Doc.of(OpenemsType.INTEGER).unit(Unit.AMPERE).accessMode(AccessMode.READ_ONLY)), //
	A_RTG_SF(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //
	PF_RTG_Q1(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), // // cos()
	PF_RTG_Q2(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), // // cos()
	PF_RTG_Q3(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), // // cos()
	PF_RTG_Q4(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), // // cos()
	PF_RTG_SF(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //
	PAD_120(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //

	/*
	 * Model SUNSPEC_121 (Inverter Controls Basic Settings)
	 */
	ID_121(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //
	L_121(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //
	W_MAX(Doc.of(OpenemsType.INTEGER).unit(Unit.WATT).accessMode(AccessMode.READ_WRITE)), //
	V_REF(Doc.of(OpenemsType.INTEGER).unit(Unit.VOLT).accessMode(AccessMode.READ_WRITE)), //
	V_REF_OFS(Doc.of(OpenemsType.INTEGER).unit(Unit.VOLT).accessMode(AccessMode.READ_WRITE)), //
	W_MAX_SF(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //
	V_REF_SF(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //
	V_REF_OFS_SF(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //

	/*
	 * Model SUNSPEC_123 (Immediate Inverter Controls)
	 */
	ID_123(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //
	L_123(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //
	CONN(Doc.of(Conn.values())), //
	W_MAX_LIM_PCT(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_WRITE)), // % WMax
	W_MAX_LIM_ENA(Doc.of(WMaxLimEna.values()).accessMode(AccessMode.READ_WRITE)), //
	OUT_PF_SET(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_WRITE)), // // cos()
	OUT_PF_SET_ENA(Doc.of(OutPFSetEna.values())), //
	VAR_W_MAX_PCT(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_WRITE)), // // % WMax
	VAR_PCT_ENA(Doc.of(VArPctEna.values()).accessMode(AccessMode.READ_WRITE)), //
	W_MAX_LIM_PCT_SF(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //
	OUT_PF_SET_SF(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //
	VAR_PCT_SF(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //

	/*
	 * Model SUNSPEC_64040 (Request REFU Parameter ID)
	 */
	ID_64040(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //
	L_64040(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //
	READ_WRITE_PARAM_ID(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_WRITE)), //
	READ_WRITE_PARAM_INDEX(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_WRITE)), //

	/*
	 * Model SUNSPEC_64041 (Request REFU Parameter ID)
	 */
	ID_64041(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //
	L_64041(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //
	READ_WRITE_PARAM_VALUE_U32(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_WRITE)), //
	READ_WRITE_PARAM_VALUE_S32(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_WRITE)), //
	READ_WRITE_PARAM_VALUE_F32(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_WRITE)), //
	READ_WRITE_PARAM_VALUE_U16(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_WRITE)), //
	READ_WRITE_PARAM_VALUE_S16(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_WRITE)), //
	READ_WRITE_PARAM_VALUE_U8(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_WRITE)), //
	READ_WRITE_PARAM_VALUE_S8(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_WRITE)), //

	/*
	 * Sunspec Model No: 64800
	 */
	ID_64800(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //
	L_64800(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_ONLY)), //
	LOC_REM_CTL(Doc.of(LocRemCtl.values()).accessMode(AccessMode.READ_WRITE)), //
	PCS_HB(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_WRITE)), //
	CONTROLLER_HB(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_WRITE)), //
	PCS_SET_OPERATION(Doc.of(PCSSetOperation.values()).accessMode(AccessMode.READ_WRITE)), //
	MAX_BAT_A_CHA(Doc.of(OpenemsType.INTEGER).unit(Unit.AMPERE).accessMode(AccessMode.READ_WRITE)), //
	MAX_BAT_A_DISCHA(Doc.of(OpenemsType.INTEGER).unit(Unit.AMPERE).accessMode(AccessMode.READ_WRITE)), //
	MAX_A(Doc.of(OpenemsType.INTEGER).unit(Unit.AMPERE).accessMode(AccessMode.READ_WRITE)), //
	MAX_A_CUR(Doc.of(OpenemsType.INTEGER).unit(Unit.PERCENT).accessMode(AccessMode.READ_WRITE)), //
	MAX_BAT_A_SF(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_WRITE)), //
	MAX_A_SF(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_WRITE)), //
	MAX_A_CUR_SF(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_WRITE)), //
	PADDING_1(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_WRITE)), //
	PADDING_2(Doc.of(OpenemsType.INTEGER).unit(Unit.NONE).accessMode(AccessMode.READ_WRITE)), //

	TEST(Doc.of(OpenemsType.BOOLEAN).accessMode(AccessMode.READ_WRITE)), //
	;

	private final Doc doc;

	private REFUStore88KChannelId(Doc doc) {
		this.doc = doc;
	}

	@Override
	public Doc doc() {
		return this.doc;
	}
}