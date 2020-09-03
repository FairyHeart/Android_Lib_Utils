[lib_utils](../../index.md) / [com.fairy.lib.utils.vo](../index.md) / [PhoneVo](./index.md)

# PhoneVo

`data class PhoneVo : Parcelable`

手机状态信息

### Parameters

`deviceId` - (IMEI) = 99000311726612 IMEI码

`deviceSoftwareVersion` - = 00

`line1Number` - = 16657138888 手机号码

`networkCountryIso` - = cn

`networkOperator` - = 46003

`networkOperatorName` - = 中国电信

`networkType` - = 6

`phoneType` - = 2 移动终端类型

`simCountryIso` - = cn

`simOperator` - = 46003 移动网络运营商名称
    中国移动（46000、46002、46007）、如中国联通（46001）、中国电信（46003）

`simOperatorName` - = 中国电信， sim卡运营商名称
    中国移动、如中国联通、中国电信

`simSerialNumber` - = 89860315045710604022

`simState` - = 5 sim卡状态

`subscriberId` - = 460030419724900(IMSI) IMSI码

`voiceMailNumber` - = *86

**Author**
: Fairy.

**Date**
: 2019-08-04.

### Constructors

| [&lt;init&gt;](-init-.md) | 手机状态信息`PhoneVo(deviceId: String?, deviceSoftwareVersion: String?, line1Number: String?, networkCountryIso: String?, networkOperator: String?, networkOperatorName: String?, networkType: Int, phoneType: Int, simCountryIso: String?, simOperator: String?, simOperatorName: String?, simSerialNumber: String?, simState: Int, subscriberId: String?, voiceMailNumber: String?)` |

### Properties

| [deviceId](device-id.md) | (IMEI) = 99000311726612 IMEI码`val deviceId: String?` |
| [deviceSoftwareVersion](device-software-version.md) | = 00`val deviceSoftwareVersion: String?` |
| [line1Number](line1-number.md) | = 16657138888 手机号码`val line1Number: String?` |
| [networkCountryIso](network-country-iso.md) | = cn`val networkCountryIso: String?` |
| [networkOperator](network-operator.md) | = 46003`val networkOperator: String?` |
| [networkOperatorName](network-operator-name.md) | = 中国电信`val networkOperatorName: String?` |
| [networkType](network-type.md) | = 6`val networkType: Int` |
| [phoneType](phone-type.md) | = 2 移动终端类型`val phoneType: Int` |
| [simCountryIso](sim-country-iso.md) | = cn`val simCountryIso: String?` |
| [simOperator](sim-operator.md) | = 46003 移动网络运营商名称     中国移动（46000、46002、46007）、如中国联通（46001）、中国电信（46003）`val simOperator: String?` |
| [simOperatorName](sim-operator-name.md) | = 中国电信， sim卡运营商名称     中国移动、如中国联通、中国电信`val simOperatorName: String?` |
| [simSerialNumber](sim-serial-number.md) | = 89860315045710604022`val simSerialNumber: String?` |
| [simState](sim-state.md) | = 5 sim卡状态`val simState: Int` |
| [subscriberId](subscriber-id.md) | = 460030419724900(IMSI) IMSI码`val subscriberId: String?` |
| [voiceMailNumber](voice-mail-number.md) | = *86`val voiceMailNumber: String?` |

